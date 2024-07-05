import { Injectable } from '@angular/core';
import { Transactions } from '../transactions';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class TransactionslistService {

  private getUrl: string = "http://localhost:8080/getAllTransactions";
  
  constructor(private httpClient: HttpClient) {
  }

  getAllTransactionsList(): Observable<Transactions[]> {
    return this.httpClient.get<Transactions[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

  addTransaction(transaction: Transactions){
    return this.httpClient.post<Transactions>(`http://localhost:8080/addTransaction`, transaction); 
  }


}
