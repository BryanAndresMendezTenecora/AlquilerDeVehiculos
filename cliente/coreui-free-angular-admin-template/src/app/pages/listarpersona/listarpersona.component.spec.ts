import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarpersonaComponent } from './listarpersona.component';

describe('ListarpersonaComponent', () => {
  let component: ListarpersonaComponent;
  let fixture: ComponentFixture<ListarpersonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarpersonaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarpersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
