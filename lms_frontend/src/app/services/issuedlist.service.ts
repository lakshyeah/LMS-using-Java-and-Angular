import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Issued } from '../issued';

@Injectable({
  providedIn: 'root'
})
export class IssuedlistService {

  private getUrl: string = "http://localhost:8080/getAllIssued";
  
  constructor(private httpClient: HttpClient) {
  }

  getAllIssuedList(): Observable<Issued[]> {
    return this.httpClient.get<Issued[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

}
