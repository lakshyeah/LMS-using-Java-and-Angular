import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IssuedListComponent } from './issued-list.component';

describe('IssuedListComponent', () => {
  let component: IssuedListComponent;
  let fixture: ComponentFixture<IssuedListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IssuedListComponent]
    });
    fixture = TestBed.createComponent(IssuedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
