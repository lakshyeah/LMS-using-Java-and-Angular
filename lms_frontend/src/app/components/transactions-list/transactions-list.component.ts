import { Component } from '@angular/core';
import { TransactionslistService } from 'src/app/services/transactionslist.service';
import { Transactions } from 'src/app/transactions';

@Component({
  selector: 'app-transactions-list',
  templateUrl: './transactions-list.component.html',
  styleUrls: ['./transactions-list.component.css']
})
export class TransactionsListComponent {
  transactions: Transactions[] | undefined;

  constructor(private transactionsService: TransactionslistService) {
  }

  ngOnInit(): void {
    this.getAllTransactions();
  }

  private getAllTransactions() {
    this.transactionsService.getAllTransactionsList().subscribe(data => {
      this.transactions = data;
    });
  }

}
