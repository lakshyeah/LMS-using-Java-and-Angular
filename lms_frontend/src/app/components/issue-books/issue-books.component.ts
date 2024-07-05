import { Component } from '@angular/core';
import { IssuebookserviceService } from 'src/app/services/issuebookservice.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MemberService } from 'src/app/services/member.service';

@Component({
  selector: 'app-issue-books',
  templateUrl: './issue-books.component.html',
  styleUrls: ['./issue-books.component.css']
})
export class IssueBooksComponent {
  issueBookForm: FormGroup;
  bookExists: boolean = false;
  memberExists: boolean = false;

  constructor(private fb: FormBuilder, private issuebookservice: IssuebookserviceService) {
    this.issueBookForm = this.fb.group({
      bookId: ['', [Validators.required, Validators.pattern(/^-?\d+$/)]],
      memberId: ['', [Validators.required, Validators.pattern(/^-?\d+$/)]],
    });
  }

  OnSubmit(): void {
    if (this.issueBookForm.valid) {
      const bookid = this.issueBookForm.get('bookId')?.value;
      const memberid = this.issueBookForm.get('memberId')?.value;
  
      // Check if bookid exists and availability is 'yes'
      this.issuebookservice.checkBookAvailability(bookid).subscribe(
        (bookExists) => {
          this.bookExists = bookExists;
  
          // Check if memberid exists
          this.issuebookservice.checkMember(memberid).subscribe(
            (memberExists) => {
              this.memberExists = memberExists;
  
              // If both book and member exist, proceed with operations
              if (this.bookExists && this.memberExists) {
                // Call function to get book details and member details
                this.issuebookservice.getBookById(bookid).subscribe(
                  (bookDetails) => {
                    // Call function to change availability
                    this.issuebookservice.changeAvailability(bookid).subscribe(
                      () => {
                        console.log('Availability changed successfully.');
  
                        // Call function to reduce availability by one
                        this.issuebookservice.reduceAvailabilityByOne(bookDetails.bookname).subscribe(
                          () => {
                            console.log('Availability reduced by one successfully.');
  
                            // Call function to create issued record
                            this.createIssuedRecord(bookid, memberid);
                          },
                          error => {
                            console.error('Error reducing availability by one:', error);
                          }
                        );
                      },
                      error => {
                        console.error('Error changing availability:', error);
                      }
                    );
                  },
                  error => {
                    console.error('Error getting book details:', error);
                  }
                );
              } else {
                console.log("Either book or member does not exist");
              }
            },
            error => {
              console.error('Error checking member existence:', error);
            }
          );
        },
        error => {
          console.error('Error checking book availability:', error);
        }
      );
    } else {
      console.log('Form is not valid. Please check the fields.');
    }
  }
  

  createIssuedRecord(bookid: number, memberid: number): void {
    // Call functions to get book details and member details
    this.issuebookservice.getBookById(bookid).subscribe(
      (bookDetails) => {
        this.issuebookservice.getMemberById(memberid).subscribe(
          (memberDetails) => {
            // Create issued record array
            const issuedRecord = {
              bookid: bookid,
              bookname: bookDetails.bookname,
              borrowdate: new Date().toISOString(),
              defaulter: 'No',
              memberid: memberid,
              membername: memberDetails.membername,
              phoneno: memberDetails.phoneno,
              emailid: memberDetails.emailid,
              standard: memberDetails.standard,
              course: memberDetails.course
            };

            // Call function to add to issued list
            this.issuebookservice.addToIssuedList(issuedRecord).subscribe(
              () => {
                console.log('Book added to issued list successfully.');
              },
              error => {
                console.error('Error adding book to issued list:', error);
              }
            );
          },
          error => {
            console.error('Error getting member details:', error);
          }
        );
      },
      error => {
        console.error('Error getting book details:', error);
      }
    );
  }
}