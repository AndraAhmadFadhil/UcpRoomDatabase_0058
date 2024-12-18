package com.example.pampertemuan11.data.dependenciedinjection

import android.content.Context
import com.example.pampertemuan11.data.database.DatabaseUCP2
import com.example.pampertemuan11.data.repository.LocalRepositoryBrg
import com.example.pampertemuan11.data.repository.LocalRepositorySpl
import com.example.pampertemuan11.data.repository.RepositoryBrg
import com.example.pampertemuan11.data.repository.RepositorySpl

interface InterfaceContainerApp {
    val repositoryBrg: RepositoryBrg
    val repositorySpl: RepositorySpl
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryBrg: RepositoryBrg by lazy {
        LocalRepositoryBrg(DatabaseUCP2.getDatabase(context).barangDao())
    }
    override val repositorySpl: RepositorySpl by lazy {
        LocalRepositorySpl(DatabaseUCP2.getDatabase(context).supplierDao())
    }

}