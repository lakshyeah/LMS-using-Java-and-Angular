import { Component } from '@angular/core';
import { Issued } from 'src/app/issued';
import { IssuedlistService } from 'src/app/services/issuedlist.service';

@Component({
  selector: 'app-issued-list',
  templateUrl: './issued-list.component.html',
  styleUrls: ['./issued-list.component.css']
})
export class IssuedListComponent {
  issuedlist: Issued[] | undefined;

  constructor(private issuedService: IssuedlistService) {
  }

  ngOnInit(): void {
    this.getAllIssued();
  }

  private getAllIssued() {
    this.issuedService.getAllIssuedList().subscribe(data => {
      this.issuedlist = data;
    });
  }

}
