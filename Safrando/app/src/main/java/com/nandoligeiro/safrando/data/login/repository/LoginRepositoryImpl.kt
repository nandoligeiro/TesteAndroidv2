package com.nandoligeiro.safrando.data.login.repository

import com.nandoligeiro.safrando.data.login.datasource.LocalLoginDataSource
import com.nandoligeiro.safrando.data.login.datasource.RemoteLoginDataSource
import com.nandoligeiro.safrando.data.login.mapper.LoginDataToDomainMapper
import com.nandoligeiro.safrando.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val dataSource: RemoteLoginDataSource,
    //private val localLoginDataSource: LocalLoginDataSource,
    private val loginDataToDomainMapper: LoginDataToDomainMapper
) : LoginRepository {
    override suspend fun postLogin(
        user: String, password: String
    ) = loginDataToDomainMapper.toDomainLogin(dataSource.postLogin(user, password))

}
