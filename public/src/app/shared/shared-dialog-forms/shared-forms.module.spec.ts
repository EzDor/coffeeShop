import { SharedDialogFormsModule } from './shared-forms.module';

describe('SharedFormsModule', () => {
  let sharedFormsModule: SharedDialogFormsModule;

  beforeEach(() => {
    sharedFormsModule = new SharedDialogFormsModule();
  });

  it('should create an instance', () => {
    expect(sharedFormsModule).toBeTruthy();
  });
});
