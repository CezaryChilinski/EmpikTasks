describe('users', () => {
  it('Verify response fields for public auth', () => {
    cy.githubApiRequest('GET', 'users/octocat').then((res) => {
      expect(res.body.login).to.eq('octocat');
      expect(res.body.id).to.eq(583231);
      expect(res.body.type).to.eq('User');
      expect(res.body.site_admin).to.eq(false);
      expect(res.body.name).to.eq('The Octocat');
      expect(res.body.email).to.be.null;
      expect(res.body.html_url).to.eq('https://github.com/octocat');
    });
  });

  it('Verify status code with wrong http method', () => {
    cy.githubApiRequest('POST', 'users/octocat', false).then((res) => {
      cy.wrap(res.status).should('eq', 404);
    });
  });
});