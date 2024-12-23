package com.example.pampertemuan11.ui.view

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pampertemuan11.ui.customwidget.TopBarHome

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    onNavigateAddSup: () -> Unit,
    onNavigateAddBrg: () -> Unit,
    onNavigateListSup: () -> Unit,
    onNavigateListBrg: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBarHome()
        }
    ) { innerPadding ->
        BodyHome(
            modifier = Modifier.padding(innerPadding),
            onBrgListClick = {
                onNavigateListBrg()
            },
            onAddSupClick = {
                onNavigateAddSup()
            },
            onListSupClick = {
                onNavigateListSup()
            },
            onAddBrgClick = {
                onNavigateAddBrg()
            }
        )
    }
}

@Composable
fun BodyHome(
    modifier: Modifier = Modifier,
    onBrgListClick: () -> Unit = {},
    onAddSupClick: () -> Unit = {},
    onListSupClick: () -> Unit = {},
    onAddBrgClick: () -> Unit = {},
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF00C6FF), Color(0xFF0072FF)),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ButtonMenu(
                namaMenu = "List Produk",
                onClick = onBrgListClick,
                namaIcon = Icons.Default.Menu,
                backgroundColor = Color(0xFF004DFF)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ButtonMenu(
                namaMenu = "Add Product",
                onClick = onAddBrgClick,
                namaIcon = Icons.Default.Add,
                backgroundColor = Color(0xFF00A6FF)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ButtonMenu(
                namaMenu = "List Supplier",
                onClick = onListSupClick,
                namaIcon = Icons.Default.Person,
                backgroundColor = Color(0xFF4CAF50)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ButtonMenu(
                namaMenu = "Add Supplier",
                onClick = onAddSupClick,
                namaIcon = Icons.Default.Add,
                backgroundColor = Color(0xFFFF9800)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonMenu(
    namaMenu: String,
    onClick: () -> Unit,
    namaIcon: ImageVector,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    val animatedScale = rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .shadow(10.dp, RoundedCornerShape(12.dp))
            .graphicsLayer(scaleX = animatedScale.value, scaleY = animatedScale.value),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = namaIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = namaMenu,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}
