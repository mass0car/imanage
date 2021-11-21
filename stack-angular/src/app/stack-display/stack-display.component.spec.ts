import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StackDisplayComponent } from './stack-display.component';

describe('StackDisplayComponent', () => {
  let component: StackDisplayComponent;
  let fixture: ComponentFixture<StackDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StackDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StackDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
