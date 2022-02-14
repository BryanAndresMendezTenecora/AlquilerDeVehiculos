import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidopruebaComponent } from './pedidoprueba.component';

describe('PedidopruebaComponent', () => {
  let component: PedidopruebaComponent;
  let fixture: ComponentFixture<PedidopruebaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidopruebaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidopruebaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
