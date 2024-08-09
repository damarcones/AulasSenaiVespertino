import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarabastecimentoComponent } from './cadastrarabastecimento.component';

describe('CadastrarabastecimentoComponent', () => {
  let component: CadastrarabastecimentoComponent;
  let fixture: ComponentFixture<CadastrarabastecimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarabastecimentoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarabastecimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
