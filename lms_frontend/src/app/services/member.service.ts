import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Member } from '../member';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class MemberService {

  private getUrl: string = "http://localhost:8080/getAllMembers";
  //static http: HttpClient;


  constructor(private http: HttpClient) {
  }


  getMembers(): Observable<Member[]> {
    return this.http.get<Member[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

  getRecords()
  {
    return this.http.get<Member[]>(`http://localhost:8080/getAllMembers`);
  }
  deleteRecord(id:number)
  {
    return this.http.delete<Member[]>(`http://localhost:8080/deleteMemberById/${id}`);
  }
  getById(id:number)
  {
    return this.http.get<Member>(`http://localhost:8080/getMemberById/${id}`); 
  }
  updateMember(id:number,add:Member)
  {
    return this.http.put<Member>(`http://localhost:8080/updateMember/${id}`,add);
  }
  addmember(add:Member)
  {
    return this.http.post<Member>(`http://localhost:8080/addMember`,add); 
  }


}
