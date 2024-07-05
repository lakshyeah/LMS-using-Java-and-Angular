import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatememberformComponent } from './updatememberform.component';

describe('UpdatememberformComponent', () => {
  let component: UpdatememberformComponent;
  let fixture: ComponentFixture<UpdatememberformComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatememberformComponent]
    });
    fixture = TestBed.createComponent(UpdatememberformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
