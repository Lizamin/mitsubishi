import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { L200Component } from './l200.component';

describe('L200Component', () => {
  let component: L200Component;
  let fixture: ComponentFixture<L200Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ L200Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(L200Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
