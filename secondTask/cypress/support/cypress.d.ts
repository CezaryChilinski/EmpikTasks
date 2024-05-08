declare namespace Cypress {
    interface Chainable {
        githubApiRequest(method: 'GET' | 'POST', endpoint: string, withError? :boolean): Chainable<any>
    }
  }
  