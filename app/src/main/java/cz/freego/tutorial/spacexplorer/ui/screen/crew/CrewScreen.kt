package cz.freego.tutorial.spacexplorer.ui.screen.crew

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.design.component.animation.PersistentLottieAnimation
import cz.freego.tutorial.core.presentation.CrewViewModel

@Composable
fun CrewScreen(viewModel: CrewViewModel = hiltViewModel()) {
    val crewMembers: LazyPagingItems<CrewMemberDto> = viewModel.crewMembers.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(crewMembers.itemCount) { index ->
            crewMembers[index]?.let { crewMember ->
                CrewItem(crewMember)
            }
        }

        crewMembers.apply {
            when {
                loadState.append.endOfPaginationReached -> {
                    //item { Text("No more data") }
                }
                loadState.refresh is androidx.paging.LoadState.Loading -> {
                    //item { CircularProgressIndicator() }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            PersistentLottieAnimation(
                                modifier = Modifier.size(64.dp),
                                assetName = "anim_rocket.lottie",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CrewItem(crewMember: CrewMemberDto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(crewMember.image),
                contentDescription = crewMember.name,
                modifier = Modifier.size(72.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = crewMember.name, style = MaterialTheme.typography.titleLarge)
                Text(text = "Agentura: ${crewMember.agency}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Status: ${crewMember.status}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
