import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarveiculosComponent } from './listarveiculos.component';

describe('ListarveiculosComponent', () => {
  let component: ListarveiculosComponent;
  let fixture: ComponentFixture<ListarveiculosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarveiculosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarveiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
