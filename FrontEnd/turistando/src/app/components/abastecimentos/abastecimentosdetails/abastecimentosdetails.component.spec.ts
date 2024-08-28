import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbastecimentosdetailsComponent } from './abastecimentosdetails.component';

describe('AbastecimentosdetailsComponent', () => {
  let component: AbastecimentosdetailsComponent;
  let fixture: ComponentFixture<AbastecimentosdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AbastecimentosdetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AbastecimentosdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
