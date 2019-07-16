import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsxComponent } from './asx.component';

describe('AsxComponent', () => {
  let component: AsxComponent;
  let fixture: ComponentFixture<AsxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
