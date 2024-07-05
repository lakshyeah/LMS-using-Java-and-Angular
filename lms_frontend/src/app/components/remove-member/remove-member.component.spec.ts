import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveMemberComponent } from './remove-member.component';

describe('RemoveMemberComponent', () => {
  let component: RemoveMemberComponent;
  let fixture: ComponentFixture<RemoveMemberComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RemoveMemberComponent]
    });
    fixture = TestBed.createComponent(RemoveMemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
