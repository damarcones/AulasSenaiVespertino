import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiculoslistComponent } from './veiculoslist.component';

describe('VeiculoslistComponent', () => {
  let component: VeiculoslistComponent;
  let fixture: ComponentFixture<VeiculoslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeiculoslistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiculoslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
