import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllbookslistComponent } from './allbookslist.component';

describe('AllbookslistComponent', () => {
  let component: AllbookslistComponent;
  let fixture: ComponentFixture<AllbookslistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllbookslistComponent]
    });
    fixture = TestBed.createComponent(AllbookslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
