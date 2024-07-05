import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {
  getMenuItems() {
    return [
      { label: 'Add Books', route: '/add-books' },
      { label: 'Add Member', route: '/add-member' },
      { label: 'Issue Book', route: '/issue-books' },
      { label: 'Transaction List', route: '/view-transactions' },
      { label: 'All Books List', route: '/view-allbookslist' },
      { label: 'Books List', route: '/view-bookslist' },
      { label: 'Member List', route: '/view-member' },
      { label: 'Issued List', route: '/view-issuedlist' }
    ];
  }
}
