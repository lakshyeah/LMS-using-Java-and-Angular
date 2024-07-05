import { Injectable } from '@angular/core';
import { Member } from '../member';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddmemberService {

  constructor(private http:HttpClient) { }

  addmember(add:Member)
  {
    return this.http.post<Member>(`http://localhost:8080/addMember`,add); 
  }

}
