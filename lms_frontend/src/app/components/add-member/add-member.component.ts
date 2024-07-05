import { Component, OnInit } from '@angular/core';  
import { Member } from '../../member';  
import { MemberService } from '../../services/member.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Transactions } from 'src/app/transactions';
import { TransactionslistService } from 'src/app/services/transactionslist.service';

@Component({
  selector: 'app-add-member',
  templateUrl: './add-member.component.html',
  styleUrls: ['./add-member.component.css']
})


export class AddMemberComponent {  

  constructor(private activatedroute:ActivatedRoute,private memberservice:MemberService,private router:Router){} 

  errorMessage="";
  add:Member;
  id:number;
  transactionservice: TransactionslistService
  transaction: Transactions;

  ngOnInit():void
  {
    this.id=this.activatedroute.snapshot.params['id']
    this.add=new Member('','','','','',''); 
  }
  saveTodo()
  {
    //console.log("Inside save member"+this.id)
      //call insert or add
        this.memberservice.addmember(this.add).subscribe
        (
          data=>
          {
            console.log(data)
            const transobj = {
              transdate: new Date().toISOString(),
              operation: this.add.membername + "with memberid" + this.add.memberid +  "was added to the library"
            }
            this.router.navigate(['view-member'])
          },
         banckenderror=>this.errorHandling(banckenderror)      
        );
  
  }

  errorHandling(banckenderror){
    console.log("inside error"+banckenderror);
    console.log("status="+banckenderror.status);
        
    if(banckenderror.status==400){
      this.errorMessage="Username already exists"
      alert("Username already exists")
    }
  }  
}  
