import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveBooksComponent } from './remove-books.component';

describe('RemoveBooksComponent', () => {
  let component: RemoveBooksComponent;
  let fixture: ComponentFixture<RemoveBooksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RemoveBooksComponent]
    });
    fixture = TestBed.createComponent(RemoveBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
