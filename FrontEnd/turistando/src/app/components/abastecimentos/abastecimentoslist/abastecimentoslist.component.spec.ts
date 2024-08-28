import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbastecimentoslistComponent } from './abastecimentoslist.component';

describe('AbastecimentoslistComponent', () => {
  let component: AbastecimentoslistComponent;
  let fixture: ComponentFixture<AbastecimentoslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AbastecimentoslistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AbastecimentoslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
