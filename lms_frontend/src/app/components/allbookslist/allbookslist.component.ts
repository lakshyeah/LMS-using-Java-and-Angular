import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AllbooksService } from 'src/app/services/allbooks.service';
import { Allbookslist } from 'src/app/allbookslist';

@Component({
  selector: 'app-allbookslist',
  templateUrl: './allbookslist.component.html',
  styleUrls: ['./allbookslist.component.css']
})
export class AllbookslistComponent implements OnInit{

  allbookslist: Allbookslist[] | undefined;

  constructor(private booksService: AllbooksService) {
  }

  ngOnInit(): void {
    this.getAllBooksList();
  }

  private getAllBooksList() {
    this.booksService.getAllBooks().subscribe(data => {
      this.allbookslist = data;
    });
  }

}
