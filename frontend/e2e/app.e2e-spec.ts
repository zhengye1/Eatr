import { EatrPage } from './app.po';

describe('eatr App', () => {
  let page: EatrPage;

  beforeEach(() => {
    page = new EatrPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
