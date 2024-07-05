import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MemberService } from '../../services/member.service';
import { Member } from '../../member';


@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {

    // added for Pagination 
    p: number = 1;
    count: number = 5;
  
  members: Member[] | undefined;

  constructor(private memberService: MemberService, private router:Router) {
  }

  // ngOnInit(): void {
  //   this.getAllMembers();
  // }

  // private getAllMembers() {
  //   this.memberService.getMembers().subscribe(data => {
  //     this.members = data;
  //   });
  // }

  ngOnInit(): void {
    // Fetch member data and populate the table
    this.memberService.getMembers().subscribe(
      (data) => {
        this.members = data;
      },
      (error) => {
        console.error('Error fetching member data:', error);
      }
    );
  }


  deleteRecord(id:number)
  {
    this.memberService.deleteRecord(id).subscribe(
      data=>
      {
        this.members=data;
      }
    )
  }
  // updateRecord(id:number)
  // {
  //   console.log(`id=${id}`)
  //   this.router.navigate(['update-member',id])
  // }

  updateRecord(memberId: number): void {
    // Redirect to the update form with member ID
    this.router.navigate(['/update-member', memberId]);
  }

}