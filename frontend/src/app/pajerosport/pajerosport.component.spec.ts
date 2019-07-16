import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PajerosportComponent } from './pajerosport.component';

describe('PajerosportComponent', () => {
  let component: PajerosportComponent;
  let fixture: ComponentFixture<PajerosportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PajerosportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PajerosportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
