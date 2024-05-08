function githubApiRequest(method: 'GET' | 'POST', endpoint: string, withError? :boolean) {
    return cy.request({
        method: method,
        url: `https://api.github.com/${endpoint}`,
        failOnStatusCode: withError,
    });
}

Cypress.Commands.add('githubApiRequest', githubApiRequest);