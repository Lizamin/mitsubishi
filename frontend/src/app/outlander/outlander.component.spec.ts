import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutlanderComponent } from './outlander.component';

describe('OutlanderComponent', () => {
  let component: OutlanderComponent;
  let fixture: ComponentFixture<OutlanderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutlanderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutlanderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
