import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PajeroComponent } from './pajero.component';

describe('PajeroComponent', () => {
  let component: PajeroComponent;
  let fixture: ComponentFixture<PajeroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PajeroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PajeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
