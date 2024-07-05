import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Member } from 'src/app/member';
import { MemberService } from 'src/app/services/member.service';

@Component({
  selector: 'app-updatememberform',
  templateUrl: './updatememberform.component.html',
  styleUrls: ['./updatememberform.component.css']
})
export class UpdatememberformComponent  implements OnInit {
  memberId: number;
  updatememberform: FormGroup;
  members: Member[] | undefined; 

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private memberService: MemberService
  ) {}

  ngOnInit(): void {
    // extract member ID from the route
    this.route.params.subscribe((params) => {
      this.memberId = +params['id'];
      // fetch member data by memberId and populate the form
      this.memberService.getById(this.memberId).subscribe(
        (member) => {
          this.updatememberform.patchValue(member);
        },
        (error) => {
          console.error('Error fetching member data:', error);
        }
      );
    });

    // initialize form
    this.updatememberform = this.fb.group({
      membername: ['', Validators.required],
      address: ['', Validators.required],
      emailid: ['', Validators.required],
      phoneno: ['', Validators.required],
      course: ['', Validators.required],
      standard: ['', Validators.required],
    });
  }

  updateMember(): void {
    if (this.updatememberform.valid) {
      const updatedMemberData = this.updatememberform.value;
      // call the service to update the member data
      this.memberService.updateMember(this.memberId, updatedMemberData).subscribe(
        (response) => {
          console.log('Member updated successfully:', response);
          // if successfully updated then redirect to member list
        },
        (error) => {
          console.error('Error updating member:', error);
        }
      );
    }
  }
}