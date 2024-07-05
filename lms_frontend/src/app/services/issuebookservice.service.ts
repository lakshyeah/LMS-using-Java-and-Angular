import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Allbookslist } from '../allbookslist';
import { Issued } from '../issued';
import { Books } from '../books';
import { Member } from '../member';
import { map } from 'jquery';


@Injectable({
  providedIn: 'root'
})
export class IssuebookserviceService {

  constructor(private http: HttpClient) { }

  checkBookAvailability(bookid: number) : Observable<boolean>{
    const url = `http://localhost:8080/checkBook/${bookid}`;
    return this.http.get<boolean>(url);
  }

  checkMember(memberid: number) : Observable<boolean>{
    const url = `http://localhost:8080/memberexists/${memberid}`;
    return this.http.get<boolean>(url);
  }

  reduceAvailabilityByOne(bookname: string): Observable<any>{
    const apiUrlWithParams = `http://localhost:8080/reducequantitybyone/${bookname}`;
    return this.http.put(apiUrlWithParams, null);
  }

  addToIssuedList(issuedobj: Issued){
    return this.http.post<Issued>(`http://localhost:8080/addIssued`, issuedobj); 
  }

  getMemberById(memberid:number){
    return this.http.get<Member>(`http://localhost:8080/getMemberById/${memberid}`); 
  }

  getBookById(bookid:number){
    return this.http.get<Allbookslist>(`http://localhost:8080/getBookById/${bookid}`); 
  }
  
  changeAvailability(bookid: number): Observable<any> {
    const apiUrlWithParams = `http://localhost:8080/changeavailabilitytoNo/${bookid}`;
    return this.http.put(apiUrlWithParams, null);
  }

}
