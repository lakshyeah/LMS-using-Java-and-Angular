import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../../services/books.service';
import { Books } from '../../books';


@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit{

  books: Books[] | undefined;

  constructor(private booksService: BooksService) {
  }

  ngOnInit(): void {
    this.getBooksList();
  }

  private getBooksList() {
    this.booksService.getBooks().subscribe(data => {
      this.books = data;
    });
  }
}
