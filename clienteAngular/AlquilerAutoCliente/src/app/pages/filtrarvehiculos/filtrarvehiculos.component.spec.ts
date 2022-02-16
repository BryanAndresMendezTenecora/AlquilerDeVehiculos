import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiltrarvehiculosComponent } from './filtrarvehiculos.component';

describe('FiltrarvehiculosComponent', () => {
  let component: FiltrarvehiculosComponent;
  let fixture: ComponentFixture<FiltrarvehiculosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FiltrarvehiculosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FiltrarvehiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
