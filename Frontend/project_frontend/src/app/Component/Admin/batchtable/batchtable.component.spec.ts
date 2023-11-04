import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BatchtableComponent } from './batchtable.component';

describe('BatchtableComponent', () => {
  let component: BatchtableComponent;
  let fixture: ComponentFixture<BatchtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BatchtableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BatchtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
