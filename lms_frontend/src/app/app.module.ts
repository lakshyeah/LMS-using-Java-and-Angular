import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DataTablesModule } from 'angular-datatables';  
import { MemberListComponent } from './components/member-list/member-list.component';  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddMemberComponent } from './components/add-member/add-member.component';
import { RemoveMemberComponent } from './components/remove-member/remove-member.component';
import { AddBooksComponent } from './components/add-books/add-books.component';
import { RemoveBooksComponent } from './components/remove-books/remove-books.component';
import { HttpClientModule } from '@angular/common/http';
import { BooksListComponent } from './components/books-list/books-list.component';
import { AllbookslistComponent } from './components/allbookslist/allbookslist.component';
import { IssuedListComponent } from './components/issued-list/issued-list.component';
import { TransactionsListComponent } from './components/transactions-list/transactions-list.component';
import { IssueBooksComponent } from './components/issue-books/issue-books.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LogoComponent } from './components/logo/logo.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxPaginationModule } from 'ngx-pagination';
import { UpdatememberformComponent } from './components/updatememberform/updatememberform.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddMemberComponent,
    RemoveMemberComponent,
    AddBooksComponent,
    RemoveBooksComponent,
    MemberListComponent,
    BooksListComponent,
    AllbookslistComponent,
    IssuedListComponent,
    TransactionsListComponent,
    IssueBooksComponent,
    SidebarComponent,
    LogoComponent,
    AboutusComponent,
    UpdatememberformComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  
    DataTablesModule,
    ReactiveFormsModule,
    BrowserAnimationsModule, 
    NgxPaginationModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
