import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Books } from '../books';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class BooksService {

  private getUrl: string = "http://localhost:8080/getBooksLists";
  
  constructor(private httpClient: HttpClient) {
  }

  getBooks(): Observable<Books[]> {
    return this.httpClient.get<Books[]>(this.getUrl).pipe(
      map(response => response)
    )
  }
}
