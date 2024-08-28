import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VeiculosdetailsComponent } from './veiculosdetails.component';



describe('VeiculosdetailsComponent', () => {
  let component: VeiculosdetailsComponent;
  let fixture: ComponentFixture<VeiculosdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeiculosdetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiculosdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
