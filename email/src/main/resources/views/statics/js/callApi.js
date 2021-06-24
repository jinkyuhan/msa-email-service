async function searchAccountsAsync(params) {
  const requestParams = new URLSearchParams();
  if (params) {
    if (params.subject) {
      requestParams.set('subject', params.subject);
    }
    if (params.query) {
      requestParams.set('query', params.query);
    }
    if (params.perPage !== undefined) {
      requestParams.set('perPage', params.perPage);
    }
    if (params.pageNum !== undefined) {
      requestParams.set('pageNum', params.pageNum);
    }
  }
  return (
    await fetch('/v1/account/?' + requestParams.toString(), {
      method: 'GET',
      credentials: 'same-origin',
    })
  ).json();
}

async function searchAccountByIdAsync(accountId) {
  return (
    await fetch('/v1/account/' + accountId, {
      method: 'GET',
      credentials: 'same-origin',
    })
  ).json();
}

async function sendAuthMailAsync(params) {
  return (
    await fetch('/v1/account/prepare-authentication', {
      method: 'POST',
      credentials: 'same-origin',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        userId: params.userId,
        emailAddress: params.email,
      }),
    })
  ).json();
}

async function searchMailAsync(params) {
  const requestParams = new URLSearchParams();
  if (params) {
    if (params.subject) {
      requestParams.set('subject', params.subject);
    }
    if (params.query) {
      requestParams.set('query', params.query);
    }
    if (params.perPage !== undefined) {
      requestParams.set('perPage', params.perPage);
    }
    if (params.pageNum !== undefined) {
      requestParams.set('pageNum', params.pageNum);
    }
  }
  return (
    await fetch('/v1/mail/?' + requestParams.toString(), {
      method: 'GET',
      credentials: 'same-origin',
    })
  ).json();
}
