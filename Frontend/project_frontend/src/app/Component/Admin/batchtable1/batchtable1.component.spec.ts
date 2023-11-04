import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Batchtable1Component } from './batchtable1.component';

describe('Batchtable1Component', () => {
  let component: Batchtable1Component;
  let fixture: ComponentFixture<Batchtable1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Batchtable1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Batchtable1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
