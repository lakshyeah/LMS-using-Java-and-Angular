import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AddbooksService } from 'src/app/services/addbooks.service';
import { Books } from 'src/app/books';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit{

  addBooksForm: FormGroup;

  constructor(private fb: FormBuilder, private addBooksService: AddbooksService) {}

  ngOnInit(): void {
    this.addBooksForm = this.fb.group({
      bookname: ['', Validators.required],
      booktopic: ['', Validators.required],
      quantity: ['', Validators.required],
      authorname: ['', Validators.required],
      category: ['', Validators.required],
      edition: ['', Validators.required],
      publisher: ['', Validators.required],
      price: ['', Validators.required],
    });
  } 



  onSubmit(): void {
    if (this.addBooksForm.valid) {
      const formData = this.addBooksForm.value;
      const allbooksdata = {
        bookname: formData.bookname,
        availability: 'Yes',
        booktopic: formData.booktopic,
        price: formData.price,
        description: '',
        edition: formData.edition,
      };
      const quantity = formData.quantity;
  
      // API calls to add data to all_books
      for (let i = 0; i < quantity; i++) {
        this.addBooksService.addtoallbookslist(allbooksdata).subscribe(
          (response) => {
            console.log('AllBooks added successfully:', response);
          },
          (error) => {
            console.error('Error adding books to all_books:', error);
          }
        );
      }
  
      // calls getBookByBookname
      this.addBooksService.getBookByBookname(formData.bookname).subscribe(
        (bookList: Books[] | Books | null | undefined) => {
          // Check if the book exists
          if (!bookList) {
            // If list is empty, then add to books_list
            const bookslistdata = {
              bookname: formData.bookname,
              authorname: formData.authorname,
              publisher: formData.publisher,
              category: formData.category,
              booktopic: formData.booktopic,
              totalquantity: formData.quantity,
              availablequantity: formData.quantity,
            };
  
            // calls addtobookslist
            this.addBooksService.addtobookslist(bookslistdata).subscribe(
              (response) => {
                console.log('Bookslist added successfully:', response);
              },
              (error) => {
                console.error('Error adding books to books_list:', error);
              }
            );
          } else {
            // If list is not empty, update the totalquantity and available quantity
            const existingBook = Array.isArray(bookList) ? bookList[0] : bookList;
  
            if (existingBook) {
              const updatedQuantity = existingBook.totalquantity + formData.quantity;
  
              const updatedBooksListData = {
                totalquantity: updatedQuantity,
                availablequantity: updatedQuantity,
              };
  
              // call updateBooksListQuantity method
              this.addBooksService.updateBooksListQuantity(existingBook.bookname, formData.quantity).subscribe(
                (response) => {
                  console.log('Bookslist updated successfully:', response);
                },
                (error) => {
                  console.error('Error updating books_list:', error);
                }
              );
            } else {
              console.error('Existing book is null.');
            }
          }
        },
        error => {
          console.error('Error while retrieving book by bookname:', error);
        }
      );
    } else {
      console.log('Form is not valid. Please check the fields.');
    }
    console.log(this.addBooksForm.value);
  } 

}