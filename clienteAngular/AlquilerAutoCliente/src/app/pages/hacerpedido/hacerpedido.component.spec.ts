import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HacerpedidoComponent } from './hacerpedido.component';

describe('HacerpedidoComponent', () => {
  let component: HacerpedidoComponent;
  let fixture: ComponentFixture<HacerpedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HacerpedidoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HacerpedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
