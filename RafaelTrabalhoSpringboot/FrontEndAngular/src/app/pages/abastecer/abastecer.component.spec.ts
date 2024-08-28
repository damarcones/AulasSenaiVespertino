import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbastecerComponent } from './abastecer.component';

describe('AbastecerComponent', () => {
  let component: AbastecerComponent;
  let fixture: ComponentFixture<AbastecerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AbastecerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AbastecerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
