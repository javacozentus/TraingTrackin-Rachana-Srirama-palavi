import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Batchtable2Component } from './batchtable2.component';

describe('Batchtable2Component', () => {
  let component: Batchtable2Component;
  let fixture: ComponentFixture<Batchtable2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Batchtable2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Batchtable2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
