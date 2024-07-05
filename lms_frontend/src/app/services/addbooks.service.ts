import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Books } from '../books';
import { Allbookslist } from '../allbookslist';

@Injectable({
  providedIn: 'root'
})
export class AddbooksService {

  private apiUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) {}

  addtobookslist(book:Books){
    return this.http.post<Books>(`http://localhost:8080/addBooksList`,book); 
  }

  addtoallbookslist(allbookslist:Allbookslist){
    return this.http.post<Allbookslist>(`http://localhost:8080/addAllBooks`,allbookslist); 
  }
 
  getBookByBookname(bookname: string): Observable<Books>{
    return this.http.get<Books>(`http://localhost:8080/getBookByBookname/${bookname}`);
  }

  private apiUrll = 'http://localhost:8080/updateQuantity/'; 
  updateBooksListQuantity(bookname: string, quantity: number): Observable<any>{
    const apiUrlWithParams = `${this.apiUrll}${bookname}/${quantity}`;
    return this.http.put(apiUrlWithParams, null);
  }
}
