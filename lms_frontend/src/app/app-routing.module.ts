import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberListComponent } from './components/member-list/member-list.component';
import { AddMemberComponent } from './components/add-member/add-member.component';
import { BooksListComponent } from './components/books-list/books-list.component';
import { AllbookslistComponent } from './components/allbookslist/allbookslist.component';
import { IssuedListComponent } from './components/issued-list/issued-list.component';
import { TransactionsListComponent } from './components/transactions-list/transactions-list.component';
import { IssueBooksComponent } from './components/issue-books/issue-books.component';
import { AddBooksComponent } from './components/add-books/add-books.component';
import { UpdatememberformComponent } from './components/updatememberform/updatememberform.component';

const routes: Routes = [
  { path: '', redirectTo: 'view-member', pathMatch: 'full' },
  { path: 'view-allbookslist', component: AllbookslistComponent },    
  { path: 'view-member', component: MemberListComponent },  
  { path: 'view-bookslist', component: BooksListComponent },  
  { path: 'view-issuedlist', component: IssuedListComponent },
  { path: 'view-transactions', component: TransactionsListComponent }, 
  { path: 'add-member', component: AddMemberComponent },
  { path: 'issue-books', component: IssueBooksComponent },
  { path: 'add-books', component: AddBooksComponent },
  { path: 'update-member/:id', component: UpdatememberformComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
