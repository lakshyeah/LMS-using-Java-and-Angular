import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Allbookslist } from '../allbookslist';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AllbooksService {

  private getUrl: string = "http://localhost:8080/getAllBooks";
  
  constructor(private httpClient: HttpClient) {
  }

  getAllBooks(): Observable<Allbookslist[]> {
    return this.httpClient.get<Allbookslist[]>(this.getUrl).pipe(
      map(response => response)
    )
  }
}
